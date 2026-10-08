package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.database.entity.AddressEntity
import com.satvikmart.data.model.Address
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class AddressRepository(private val db: AppDatabase) {
    fun getAllAddresses(): Flow<List<Address>> =
        db.addressDao().getAllAddresses().map { entities ->
            entities.map { it.toAddress() }
        }

    suspend fun getAddressById(addressId: String): Address? =
        db.addressDao().getAddressById(addressId)?.toAddress()

    suspend fun getDefaultAddress(): Address? =
        db.addressDao().getDefaultAddress()?.toAddress()

    suspend fun addAddress(address: Address) {
        db.addressDao().insertAddress(
            AddressEntity(
                id = UUID.randomUUID().toString(),
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

    suspend fun updateAddress(address: Address) {
        db.addressDao().updateAddress(
            AddressEntity(
                id = address.id,
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
        db.addressDao().deleteAddress(
            AddressEntity(
                id = address.id,
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

    suspend fun setDefaultAddress(addressId: String) {
        db.addressDao().clearDefaultAddress()
        val address = db.addressDao().getAddressById(addressId)
        if (address != null) {
            db.addressDao().updateAddress(address.copy(isDefault = true))
        }
    }

    private fun AddressEntity.toAddress() = Address(
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
