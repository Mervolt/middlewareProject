from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.protocol.TMultiplexedProtocol import TMultiplexedProtocol
from thrift.transport.TTransport import TTransportException
import sys
import glob
import pygen.Fridge as Fridge
import pygen.Camera as Camera
import pygen.Device as Device
import pygen.TemperatureSensor as Sensor
from pygen.Camera import AngularPosition
from pygen.ttypes import InvalidArguments
import time

def main():
    transport = TSocket.TSocket('localhost', 9081)

    transport = TTransport.TBufferedTransport(transport)

    protocol = TBinaryProtocol.TBinaryProtocol(transport)

    device = Device.Client(TMultiplexedProtocol(protocol, "Device"))
    fridge = Fridge.Client(TMultiplexedProtocol(protocol, "Fridge"))
    camera = Camera.Client(TMultiplexedProtocol(protocol, "Camera"))
    sensor = Sensor.Client(TMultiplexedProtocol(protocol, "TemperatureSensor"))

    try:
        transport.open()
        while True:
            print("Write 1. to list all devices ")
            print("Write 2. to operate on fridges ")
            print("Write 3. to operate on cameras ")
            print("Write 4. to operate sensors ")
            action = input()
            if action == '1':
                for dev in device.getEveryDevice():
                    print(dev)
            elif action == '2':
                print("Write down in format operationNumber/arg1_arg2...")
                print("1.start freezing/id")
                print("2.stop freezing/id")
                print("3.change temp/id_value")
                print("4.get temp and is freezing/id")
                print("5.turn on/id")
                print("6.turn off/id")
                print("7.get state/id")
                target = input()
                command = target.split("/")
                operation = command[0]
                args = command[1]
                if operation == '1':
                    print(fridge.startFreezing(args))
                elif operation == '2':
                    print(fridge.stopFreezing(args))
                elif operation == '3':
                    arg_split = args.split("_")
                    dev_id = arg_split[0]
                    value = arg_split[1]
                    print(fridge.changeTemperatureTo(dev_id, int(value)))
                elif operation == '4':
                    print(fridge.getTemperatureAndIsFreezing(args))
                elif operation == '5':
                    print(fridge.turnOn(args))
                elif operation == '6':
                    print(fridge.turnOff(args))
                elif operation == '7':
                    print(fridge.getState(args))
                else:
                    pass
            elif action == '3':
                print("Write down in format operationNumber/arg1_arg2...")
                print("1.move to position and zoom/id_verticalAngle_horizontalAngle_zoom")
                print("2.turn on/id")
                print("3.turn off/id")
                print("4.get state/id")
                print("5.to go to menu")
                target = input()
                command = target.split("/")
                operation = command[0]
                args = command[1]
                if operation == '1':
                    argSplit = args.split("_")
                    position = AngularPosition(int(argSplit[1]), int(argSplit[2]))
                    print(camera.moveToPositionAndZoom(argSplit[0], position, int(argSplit[3])))
                elif operation == '2':
                    print(camera.turnOn(args))
                elif operation == '3':
                    print(camera.turnOff(args))
                elif operation == '4':
                    print(camera.getState(args))
                else:
                    pass
            elif action == '4':
                print("Write down in format operationNumber/arg1_arg2...")
                print("1.change alarm temperature value/id_alarmValue")
                print("2.get temperature/id")
                print("3.turn on/id")
                print("4.turn off/id")
                print("5.get state/id")
                print("6.to go to menu")
                target = input()
                command = target.split("/")
                operation = command[0]
                args = command[1]
                if operation == '1':
                    argSplit = args.split("_")
                    sensor.changeAlarmTemperatureValue(argSplit[0], int(argSplit[1]))
                elif operation == '2':
                    print(sensor.getTemperature(args))
                elif operation == '3':
                    print(sensor.turnOn(args))
                elif operation == '4':
                    print(sensor.turnOff(args))
                elif operation == '5':
                    print(sensor.getState(args))
                else:
                    pass
            else:
                pass

    except InvalidArguments as iarg:
        print(iarg)
        main()
    except IndexError as ierr:
        print("WRONG PARSED COMMAND - TOO LESS INDICES")
        transport.close()
        main()
    except ValueError as verr:
        print("WRONG PARSED COMMAND - WRONG VALUE")
        transport.close()
        main()
    except TTransportException as tterr:
        print("Connection closed - Trying to reconnect")
        transport.close()
        main()
    except ConnectionResetError as conerr:
        print("Connection not established - waiting for another reconnect")
        time.sleep(10)
        transport.close()
        main()


    transport.close()

main()