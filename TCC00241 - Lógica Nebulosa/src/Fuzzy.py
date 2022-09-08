import numpy as np
import skfuzzy as fuzzy
from src.Config import Config
import matplotlib.pyplot as plt
from skfuzzy import control as ctrl


class Fuzzy:

    def __init__(self):

        #pegando o range do universo do arquivo Config
        setting = Config['fuzzy']['range']
        self.behind_red_light_range = setting['behind_red_light']
        self.arriving_green_light_range = setting['arriving_green_light']
        self.extension_range = setting['extension']

        #criacao dos universos dos sets de input e output respectivamente
        self.behind_red_light = ctrl.Antecedent(self.behind_red_light_range, 'Queue')
        self.arriving_green_light = ctrl.Antecedent(self.arriving_green_light_range, 'AVG Num of Cars in Transit')
        self.extension = ctrl.Consequent(self.extension_range, 'Extension Time', defuzzify_method='centroid')

        #cria o conjunto nebuloso referente a Queue
        setting = Config['fuzzy']['membership_function']['behind_red_light'] #pega os parametros de criacao do trapezio do arquivo config
        self.behind_red_light['few'] = fuzzy.trimf(self.behind_red_light.universe, setting['few'])
        self.behind_red_light['small'] = fuzzy.trimf(self.behind_red_light.universe, setting['small'])
        self.behind_red_light['medium'] = fuzzy.trimf(self.behind_red_light.universe, setting['medium'])
        self.behind_red_light['many'] = fuzzy.trapmf(self.behind_red_light.universe, setting['many'])
        #self.behind_red_light['many'] = fuzzy.trimf(self.behind_red_light.universe, setting['many'])

        #cria o conjunto nebuloso referente a Arrivel Rate
        setting = Config['fuzzy']['membership_function']['arriving_green_light'] #pega os parametros de criacao do trapezio do arquivo config
        self.arriving_green_light['few'] = fuzzy.trimf(self.arriving_green_light.universe, setting['few'])
        self.arriving_green_light['small'] = fuzzy.trimf(self.arriving_green_light.universe, setting['small'])
        self.arriving_green_light['medium'] = fuzzy.trimf(self.arriving_green_light.universe, setting['medium'])
        self.arriving_green_light['many'] = fuzzy.trapmf(self.arriving_green_light.universe, setting['many'])
        #self.arriving_green_light['many'] = fuzzy.trimf(self.arriving_green_light.universe, setting['many'])

        #cria o conjunto nebuloso referente a Arrivel Rate
        setting = Config['fuzzy']['membership_function']['extension'] #pega os parametros de criacao do trapezio do arquivo config
        self.extension['zero'] = fuzzy.trimf(self.extension.universe, setting['zero'])
        self.extension['short'] = fuzzy.trimf(self.extension.universe, setting['short'])
        self.extension['medium'] = fuzzy.trimf(self.extension.universe, setting['medium'])
        self.extension['long'] = fuzzy.trimf(self.extension.universe, setting['long'])

        # Rule 1: If AVG Num of Cars in Transit is few then Extension is zero.
        # Rule 2: If AVG Num of Cars in Transit is small AND Queue is (few OR small) then Extension is short.
        # Rule 3: If AVG Num of Cars in Transit is small AND Queue is (medium OR many) then Extension is zero.
        # Rule 4: If AVG Num of Cars in Transit is medium AND Queue is (few OR small) then Extension is medium.
        # Rule 5: If AVG Num of Cars in Transit is medium AND Queue is (medium OR many) then Extension is short.
        # Rule 6: If AVG Num of Cars in Transit is many AND Queue is (few OR small) then Extension is long.
        # Rule 7: If AVG Num of Cars in Transit is many AND Queue is medium then Extension is medium.
        # Rule 8: If AVG Num of Cars in Transit is many AND Queue is many then Extension is short.
        
        '''
        Tabela de Regras
             AVG Num of Cars in Transit   |                    Queue
                                          |  few        small         medium       many
                       few                |  zero       zero           zero        zero
                       small              | short       short          zero        zero
                       medium             | medium      medium         short       short
                       many               |  long       long          medium       short

        '''

        self.rules = [
            # Regra 1: Se o numero medio de carros em transito é few, então a extensão é zero
            ctrl.Rule(antecedent=self.arriving_green_light['few'], consequent=self.extension['zero']),

            # Regra 2: Se o numero medio de carros em transito é small e a fila é few ou small, então a extensão é short
            ctrl.Rule(antecedent=(self.arriving_green_light['small'] & (self.behind_red_light['few'] | self.behind_red_light['small'])),
                      consequent=self.extension['short']),
            
            # Regra 3: Se o numero medio de carros em transito é small e a fila é medium ou many, então a extensão é zero
            ctrl.Rule(antecedent=(self.arriving_green_light['small'] & (self.behind_red_light['medium'] | self.behind_red_light['many'])),
                      consequent=self.extension['zero']),
            
            # Regra 4: Se o numero medio de carros em transito é medium e a fila é few ou small, então a extensão é medium
            ctrl.Rule(antecedent=(self.arriving_green_light['medium'] & (self.behind_red_light['few'] | self.behind_red_light['small'])),
                      consequent=self.extension['medium']),
            
            # Regra 5: Se o numero medio de carros em transito é medium e fila é medium or many, então a extensão é short
            ctrl.Rule(antecedent=(self.arriving_green_light['medium'] & (self.behind_red_light['medium'] | self.behind_red_light['many'])),
                      consequent=self.extension['short']),
            
            # Regra 6: Se o numero medio de carros em transito é many e fila é few ou small, então a extensão é longa
            ctrl.Rule(antecedent=(self.arriving_green_light['many'] & (self.behind_red_light['few'] | self.behind_red_light['small'])),
                      consequent=self.extension['long']),
            
            # Regra 7: Se o numero medio de carros em transito é many e a fila é medium, então a extensão é medium
            ctrl.Rule(antecedent=(self.arriving_green_light['many'] & (self.behind_red_light['medium'])),
                      consequent=self.extension['medium']),
            
            # Regra 8: Se o numero medio de carros em transito é many e a fila é many, então extensão é short.
            ctrl.Rule(antecedent=(self.arriving_green_light['many'] & (self.behind_red_light['many'])),
                      consequent=self.extension['short'])
        ]

        #inicializa sistema e simulador
        self.extension_ctrl = ctrl.ControlSystem(self.rules)
        self.extension_sim = ctrl.ControlSystemSimulation(self.extension_ctrl)

    def get_extension(self, arriving_green_light_car, behind_red_light_car, extension_count):
        #força a resetar toda vez que roda caso exista lixo
        self.extension_sim._clear_outputs()
        self.extension_sim._reset_simulation()

        #Entradas crisp
        self.extension_sim.input['Queue'] = behind_red_light_car
        self.extension_sim.input['AVG Num of Cars in Transit'] = arriving_green_light_car

        #Computa a saida
        self.extension_sim.compute()

        #Saida Crisp
        saida_crisp = self.extension_sim.output['Extension Time']

        #print("fuzzy", saida_crisp)

        return saida_crisp



if __name__ == '__main__':
    fuzzy = Fuzzy()
    fuzzy.behind_red_light.view()
    fuzzy.arriving_green_light.view()
    fuzzy.extension.view()

    plt.show()