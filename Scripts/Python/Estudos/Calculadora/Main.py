import kivy
from kivy.app import App
kivy.require('1.9.0')
from kivy.uix.gridlayout import GridLayout
from kivy.config import Config
from kivy.uix.label import Label

Config.set('graphics', 'resizable', 1)

class CalcGrid(GridLayout):
    def calculate(self, calc, *kwargs):
        if calc:
            try:
                self.display.text = str(eval(calc))
            except Exception:
                self.display.text = 'Error'

class Calculator(App):
    def build(self):
        return CalcGrid()

calc_app = Calculator()
calc_app.run()