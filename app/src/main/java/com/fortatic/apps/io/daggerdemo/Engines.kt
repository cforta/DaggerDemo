package com.fortatic.apps.io.daggerdemo

import com.fortatic.apps.io.daggerdemo.di.EngineSpecs
import com.fortatic.apps.io.daggerdemo.di.SpecsQualifier
import timber.log.Timber
import javax.inject.Inject

interface Engine {
    fun startEngine()
}

/**
 * Agregamos la anotación @Inject porque ahora Dagger creará una
 * instancia de esta clase, nosotros proveeremos el @param model
 * CarComponent.
 */
class ElectricEngine @Inject constructor(
    @SpecsQualifier(EngineSpecs.ModelEngine) private val modelEngine: String,
    @SpecsQualifier(EngineSpecs.PowerEngine) private val powerEngine: Int
) :
    Engine {
    override fun startEngine() {
        Timber.d("electric engine: $modelEngine[${powerEngine}W] started")
    }
}

class DieselEngine @Inject constructor() :
    Engine {
    override fun startEngine() {
        Timber.d("diesel engine started")
    }
}