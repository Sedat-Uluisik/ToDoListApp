package com.sedat.todolistapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.sedat.todolistapp.ui.ToDoFragment
import javax.inject.Inject

class FragmentFactoryToDo@Inject constructor(

): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            ToDoFragment::onDestroyView.name -> ToDoFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}