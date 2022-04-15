# OOP2_Assignment

Team Members : Christina Vargka (C20737009), Anis Dizdarevic (C20345816), Ho Chung (C20348256)

# How the Program Works

This program is automated and will load the audio and also load 5 different patterns in 30 second intervals. These patterns will then play for the duration of the audio.

# How the Functions Operate

## smoothedAmplitude :
1. The values from the Audiobuffer are summed up.
2. The average values of the audiobuffer are lerped then returned.


# How the Classes Operate

## Dancing Triangle : 
1. Once the instance of a DancingTriangle is created, the program uses its render() function.
2. The value returned by smoothedAmplitude() is updated and passed with eaach frame.
3. The centre of the screen is calculated, and the first x, y of the screen are calculated according to the centre, and the radius of the shape.
4. The radius changes and increases by the amplitude.
5. The colour of the lines change by the amplitude.
6. The points necessary to create the triangle are calculated by the sin() and cos() of a Theta (map() function).

## Flame : 
1. The 'Flame.java' file is created, which will store the main code for the 'Flame' function.
2. A lerpbuffer is created which will be used to slow down the change in frequency.
3. Passing the lerbuffer and 'i' value (the width) results in the 'Flame.java' rendering.
4. Using the PApplet map function, we generate the range of heights of the 'Flame'.
5. The Flame is displayed using the line function.


## Square : 
1. A specific number (50) of the 'Square.java' class objects are created, each respresenting an individual square.
2. Data is passed to all of the 'Square' objects by using a for loop.
3. All of the 'Square' functions are rendered and updated by using a for loop.
4. The rendering functions by drawing the 'Square' and using 'pushMatrix' and 'popMatrix' which allow us to rotate and translate the square to any position we desire.
5. The 'Square' is updated by updating the location of x and y, and also the duration of the 'Square'.
6. The speed of the squares increases depending on the amplitude of the sound.

## Square Train: 
1. A specific number (20) of the 'SquareTrain.java' function is created, each respresenting a 'train' of squares.
2. Data is passed to all of the 'SquareTrain' functions by using a for loop.
3. All of the 'SquareTrain' functions are rendered and updated by using a for loop.
4. The rendering functions by drawing the 'SquareTrain' and using 'pushMatrix' and 'popMatrix' which allow us to rotate and translate the square to any position we desire.
5. The 'SquareTrain' is updated by updating the location of x and y.

## Circle :
1. Once the instance of a Circle is created, the program uses its render() function.
2. The value returned by smoothedAmplitude, the value of the lerpedBuffer, the index and the size of the buffer are passed into its render() function.
3. This function creates a circular waveform, that expands with changes in the amplitude.
4. The peaks are calculated using the difference between the radius of the circle, and the added absolute value of f multiplied by the sin, cos of theta.

## Ending :
1. The 'Ending.java' file function is created and the data gets passed. (This file only runs when the audio has finished playing)
2. We check is the 'ab.get()' is equal to zero which means the audio has finished playing. The 'Ending' then renders and updates.
3. The rendering functions by drawing the text out on the screen
4. The 'Ending' is updated by updating the location of y.
