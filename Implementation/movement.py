from pynput.keyboard import Key, Controller
import time
keyboard = Controller()
import mouse
while(True):
    f=open("data.txt",'r')
    data=f.read()
    
    f.close()
    if data!='':
        print(data)
        if data=='a' or data=='s' or data=='w' or data=='d':
            print(data," pressed")
            keyboard = Controller()
            keyboard.press(data)
            keyboard.release(data)
            f=open("data.txt",'w')
            f.write('')
            f.close()
        elif data=='l':
            print(data," pressed")
            mouse.drag(0, 0, -100, 2, absolute=False, duration=0.1)
        elif data=='r':
            print(data," pressed")
            mouse.drag(0, 0, 100, 2, absolute=False, duration=0.1)
        
        time.sleep(1)
            
            



