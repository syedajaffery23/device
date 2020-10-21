Device Library Management System

Scenario Overview
An area library is considering letting patrons checkout electronic devices such as tablets. It is therefore
commissioning a prototype of a device management and checkout system by a group of talented CIS
programmers studying object-oriented design!

At the start, the library would like to start building a basic list of devices they have in stock. Having a
prototype would give them the ability to see both possibilities and shortcomings, refine their own
requirements and expectations, and then go to a software development consultant. In their basic
prototype, the library would like a demonstration of a simple system which allows maintenance of
device information.

Following are the general specifications of what the library wants. While there are some specifics
provided, the library leaves the nitty-gritty implementation details in the good hands of its capable
programming team.
1) The library maintains a list of electronic devices. Each device has a Stock Keeping Unit (SKU) code, which
is an alphanumeric code up to 6 letters in length. Each device also has a name. The library would like to
keep track of whether each device is available or not. Devices are checked out already are considered
“not available”, whereas devices that are “available” can be checked out.
2) Since the library is commissioning an object-oriented prototype, they would really like objects to model
Devices. Each device should have inside it all the attributes, which need to be tracked.
3) The library has heard arrays are a good way to store a series of logically related objects although they
don’t know much about them. They hope that their talented designers will come up with some
sophisticated design that would be reusable and extensible in the years to come!

For its management purposes, the library would like the following. 
1) A main menu should present the user with options. Users should be able to see a list of devices, add a new device, edit an existing device,
search for a device by name, and check out a device. 
2) The main menu should ask which option the user would like to select and perform that action. 
3) After completion, the user should be brought back to the main menu. 
4) The main menu should also allow users to cleanly exit the application. 
5) Also, needless to say, the library would prefer if its application did not crash – ever. If the system goes down, it might 
take down other systems with it and the library cannot afford to have no way to check out material! That would be a bad result for the development team.
