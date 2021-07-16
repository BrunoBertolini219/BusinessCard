package br.com.brunoccbertolini.businesscard

import android.app.Application
import br.com.brunoccbertolini.businesscard.data.AppDatabase
import br.com.brunoccbertolini.businesscard.data.BusinessCardRepository

class App: Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}