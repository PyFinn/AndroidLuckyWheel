# AndroidLuckyWheel
Simple Lucky Wheel for Android Aplications

## About
This is a simple Android Studio Project containing a Lucky Wheel / Wheel of Fortune. Feel free to use the Code in your own Android Apps. The Project contains just one simple Java Class extending an AppCompatActivity which handles Button Click´s 
and cares about the Animation & Animation Result stuff. The code is kept quite simple and is built for flexibility, you can easily implement your own Wheel Designs with putting them into your drawable folder (should be .png), the ranges
can be edited easily.

![App in action](https://i.ibb.co/f2drDFj/Bildschirmfoto-2020-07-21-um-16-34-09.png)

## Usage
The App is pretty simple to use, you can easily implement the functionality to your own app. Most important components:
- PNG File in the drawable folder which is the source of your ImageView showing the Wheel. If the pieces of the Wheel have different sizes, you should know their size to be able to be precise in rewarding.
- Rotating Animation. You can do many specifications there, mostly you´ll make changes in animation duration and interpolator
- Rewards. Pretty easy to configure if you know the exact degrees on where one field starts / ends, simply have a look at the "currentNumber" function in MainActivity.

## ToDo
1. Remove little lags when spinning the wheel. (Maybe the file is too big?)
2. Create Library to allow easier implementation of the Lucky Wheel (some of those are already around on github)
3. Build multiple Wheel Designs
