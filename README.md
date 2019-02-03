# drawing-project
A simple Java drawing program

## Purpose
This was literally just a Java program I made for the practice as part of an assignment.

Don't actually try to use it to draw anything, because it will be overly cumbersome, and most certainly won't meet your needs.

## How to Use
Everything is encapsulated in the class `Drawing`.

Since Drawing is an `ArrayList`, you can treat it as such, with all the standard methods included in `ArrayList`.
It can only contain `Shapes` and `ShapeGroups`.

Drawing also contains a few additional methods to do things like set the background image or the dimensions.
There's also `refresh()` which renders the drawing. You have to call this whenever you want to update what's on the screen.

### Shapes
* `Shape` (abstract)
    * `Polygon` (abstract)
        * `Rectangle`
            * `Square`
            * `GradientRectangle`
        * `RightTriangle`
    * `Circle`
    * `LineSegment`

### ShapeGroups

`ShapeGroups` behave like `Shapes`, but instead of being a `Shape` themselves, they contain `Shapes` (and other `ShapeGroups`).

They're also `ArrayLists` (that an only contain `Shapes` and `ShapeGroups`), so all the standard methods from `ArrayList` apply.

Since they also behave like `Shapes`, you can set their position and color.
The default position of a `ShapeGroup` is (0, 0), but can be set to anything. It will shift the position of everything inside it by the same amount.
Setting the color of a `ShapeGroup` will set the color of everything inside it to that value.

## Explanations
Everything in this section is merely part of the assignment.

### Shape
`Shape` is abstract so that all its children can inherit its properties (such as position and color),
but so that it doesn't have to implement the methods in `Drawable`, it can force its children to do that.

### Rectangle
`Rectangle` extends `Polygon` since I wanted both `Rectangle` and `RightTriangle` to share a lot of attributes (height and width).

`Rectangle` inherits most of its attributes from and `Polygon` so they don't have to be implemented multiple times in every other child of `Polygon`.

### RightTriangle
`RightTriangle` extends `Polygon` since I wanted both `Rectangle` and `RightTriangle` to share a lot of attributes (height and width).

`RightTriangle` inherits most of its attributes from and `Polygon` so they don't have to be implemented multiple times in every other child of `Polygon`.

### LineSegment
`LineSegment` extends `Shape` since giving it attributes of a `Polygon` (height and width) didn't make sense, but it did share things such as position and color.

### ShapeGroup
`ShapeGroup` extends `ArrayList<Drawable>` since its purpose is to hold `Drawables`, and `ArrayList` is designed to hold objects.
I didn't have to reimplement methods to add and remove elements of the `ArrayList`, since all those were just inherited.

Since `ShapeGroup` can hold `Drawables`, that means it can use Polymorphism to hold anything that implements `Drawable`.
This in turn means that it can hold both `Shapes` and other `ShapeGroups`.
When it's iterating through them, it automatically decides which implementation of the methods from `Drawable` to use.

Since `ShapeGroup` already extends `ArrayList`, it can't inherit from anything else (that isn't a parent of `ArrayList`).
In order to be a `Drawable` for Polymorphism, `Drawable` would have to be an interface, since there's no interface limit in Java.