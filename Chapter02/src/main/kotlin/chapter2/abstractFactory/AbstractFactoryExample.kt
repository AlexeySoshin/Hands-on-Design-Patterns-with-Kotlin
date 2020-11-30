package chapter2.abstractFactory

import chapter2.abstractFactory.InfantryUnits.*
import chapter2.abstractFactory.VehicleUnits.*

fun main() {

    val hq = CatHQ()
    val barracks1 = hq.buildBarracks()
    val barracks2 = hq.buildBarracks()
    val vehicleFactory1 = hq.buildVehicleFactory()

    val units = listOf(
            barracks1.build(RIFLEMEN),
            barracks2.build(ROCKET_SOLDIER),
            barracks2.build(ROCKET_SOLDIER),
            vehicleFactory1.build(TANK),
            vehicleFactory1.build(APC),
            vehicleFactory1.build(APC)
    )

    println(units)
}

interface Types

enum class InfantryUnits : Types {
    RIFLEMEN,
    ROCKET_SOLDIER
}

enum class VehicleUnits : Types {
    APC,
    TANK
}

interface Building<in UnitType, out ProducedUnit>
        where UnitType : Types, ProducedUnit : Unit {
    fun build(type: UnitType) : ProducedUnit
}


interface HQ {
    fun buildBarracks(): Building<InfantryUnits, Infantry>
    fun buildVehicleFactory(): Building<VehicleUnits, Vehicle>
}

class CatHQ : HQ {
    val buildings = mutableListOf<Building<*, Unit>>()

    override fun buildBarracks(): Building<InfantryUnits, Infantry> {
        val b = object : Building<InfantryUnits, Infantry> {
            override fun build(type: InfantryUnits): Infantry {
                return when (type) {
                    RIFLEMEN -> Rifleman()
                    ROCKET_SOLDIER -> RockerSoldier()
                }
            }
        }
        buildings.add(b)
        return b
    }

    override fun buildVehicleFactory(): Building<VehicleUnits, Vehicle> {
        val vf = object : Building<VehicleUnits, Vehicle> {
            override fun build(type: VehicleUnits) = when (type) {
                APC -> APC()
                TANK -> Tank()
            }
        }
        buildings.add(vf)

        return vf
    }
}

interface Unit

interface Vehicle : Unit

interface Infantry : Unit

class Rifleman : Infantry

class RockerSoldier : Infantry

class APC : Vehicle

class Tank : Vehicle