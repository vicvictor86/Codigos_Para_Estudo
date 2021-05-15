view wave 
wave clipboard store
wave create -driver freeze -pattern clock -initialvalue 0 -period 100ns -dutycycle 50 -starttime 0ns -endtime 1000ns sim:/tarefa01/A 
wave create -driver freeze -pattern clock -initialvalue 0 -period 200ns -dutycycle 50 -starttime 0ns -endtime 1000ns sim:/tarefa01/B 
WaveCollapseAll -1
wave clipboard restore
