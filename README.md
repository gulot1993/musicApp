# musicApp

Design pattern used: Model-View-ViewModel (MVVM)
- I used this one coz updating data through LiveData is very easy and the
view model is decoupled on View. The disadvantages of using this one is, if you will
not handle your livedata correctly, there's a possibility that the data that is only for
1 view will be visible to another view.

Storage used: Room DB
- I used room db on this project coz it is very easy to implement compared to the old implementation.

Abstracting data: Repository Pattern
- I used repository pattern for abstracting data on different data sources.

Dependency Injection Library: Dagger
- Dagger is commonly used for android developers when it comes to dependency injection.
