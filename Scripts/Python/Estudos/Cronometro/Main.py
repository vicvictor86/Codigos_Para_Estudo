import kivy
kivy.require('1.9.0')
from kivy.app import App
from kivy.uix.boxlayout import BoxLayout
from kivy.properties import StringProperty,NumericProperty,BooleanProperty
from kivy.clock import Clock
 
class TimerWidget(BoxLayout):
    Value = NumericProperty()
    Minute = NumericProperty()
    Hours = NumericProperty()
    ValueText = StringProperty()
    couting = BooleanProperty()
 
    couting = False
 
    def update(self, *args):
        self.ValueText = "{:0>2}:{:0>2}:{:0>2}".format(self.Hour, self.Minute, self.Value)
        if self.couting == True:
            self.Value = round(self.Value + 0.1, 2)
            if(self.Value >= 60):
                self.Value = 0
                self.Minute += 1
                if(self.minute >= 60):
                    self.Hours += 1
 
    def reset(self):
        if self.couting == False:
            self.Value = 0
            self.Minute = 0
            self.Hour = 0
 
    def start(self):
        self.Value = 0
        self.Minute = 0
        self.Hour = 0
        self.couting = True
 
    def stop(self):
        self.couting = False
 
    def restart(self):
        self.Value = 0
        self.Minute = 0
        self.Hour = 0
 
class timer(App):
    def build(self):
        timer = TimerWidget()
        timer.Value = 0
        timer.Minute = 0
        timer.Hour = 0
        Clock.schedule_interval(timer.update, 0.1)
        return timer      
 
if __name__ == '__main__':
    timer().run()