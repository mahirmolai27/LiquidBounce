/*
 * This file is part of LiquidBounce (https://github.com/CCBlueX/LiquidBounce)
 *
 * Copyright (c) 2016 - 2020 CCBlueX
 *
 * LiquidBounce is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LiquidBounce is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LiquidBounce. If not, see <https://www.gnu.org/licenses/>.
 */

package net.ccbluex.liquidbounce.module.modules.combat

import net.ccbluex.liquidbounce.event.PacketReceiveEvent
import net.ccbluex.liquidbounce.module.Module
import net.ccbluex.liquidbounce.module.Category
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket

object Velocity : Module("Velocity", Category.COMBAT) {

    val packetReceiveHandler = handler<PacketReceiveEvent> {
        val packet = it.packet

        if (packet is EntityVelocityUpdateS2CPacket && packet.id == mc.player?.entityId) {
            it.cancelEvent()
        }
    }

}