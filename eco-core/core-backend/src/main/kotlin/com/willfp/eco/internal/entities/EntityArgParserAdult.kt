package com.willfp.eco.internal.entities

import com.willfp.eco.core.entities.args.EntityArgParseResult
import com.willfp.eco.core.entities.args.EntityArgParser
import org.bukkit.entity.Ageable

class EntityArgParserAdult : EntityArgParser {
    override fun parseArguments(args: Array<out String>): EntityArgParseResult? {
        var baby = false

        for (arg in args) {
            if (arg.equals("adult", true)) {
                baby = true
            }
        }

        if (!baby) {
            return null
        }

        return EntityArgParseResult(
            {
                if (it !is Ageable) {
                    return@EntityArgParseResult false
                }

                it.isAdult
            },
            {
                (it as? Ageable)?.setAdult()
            }
        )
    }
}