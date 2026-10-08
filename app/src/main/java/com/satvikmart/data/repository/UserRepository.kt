package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.database.entity.AddressEntity
import com.satvikmart.data.model.Address
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class AddressRepository(private val db: AppDatabase) {
    fun getAllAddresses(): Flow<List<Address>> = db.addressDao().getAllAddresses().map { it.map(AddressEntity::toModel) }

    suspend fun addAddress(address: Address) {
        db.addressDao().insertAddress(
            AddressEntity(
                id = address.id.ifBlank { UUID.randomUUID().toString() },
                name = address.name,
                mobile = address.mobile,
                houseFlat = address.houseFlat,
                street = address.street,
                area = address.area,
                landmark = address.landmark,
                city = address.city,
                state = address.state,
                pin = address.pin,
                type = address.type,
                isDefault = address.isDefault
            )
        )
    }

    suspend fun deleteAddress(address: Address) {
        db.addressDao().deleteAddress(address.toEntity())
    }

    suspend fun getDefaultAddress(): Address? = db.addressDao().getDefaultAddress()?.toModel()

    private fun Address.toEntity() = AddressEntity(
        id = id,
        name = name,
        mobile = mobile,
        houseFlat = houseFlat,
        street = street,
        area = area,
        landmark = landmark,
        city = city,
        state = state,
        pin = pin,
        type = type,
        isDefault = isDefault
    )

    private fun AddressEntity.toModel() = Address(
        id = id,
        name = name,
        mobile = mobile,
        houseFlat = houseFlat,
        street = street,
        area = area,
        landmark = landmark,
        city = city,
        state = state,
        pin = pin,
        type = type,
        isDefault = isDefault
    )
}
