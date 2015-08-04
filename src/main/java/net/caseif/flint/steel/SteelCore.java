/*
 * New BSD License (BSD-new)
 *
 * Copyright (c) 2015 Maxim Roncacé
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     - Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     - Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     - Neither the name of the copyright holder nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.caseif.flint.steel;

import net.caseif.flint.FlintCore;
import net.caseif.flint.Minigame;
import net.caseif.flint.common.CommonCore;
import net.caseif.flint.steel.util.SteelUtils;

/**
 * Implements {@link FlintCore}.
 *
 * @author Max Roncacé
 */
public class SteelCore extends CommonCore {

    private static boolean VERBOSE_LOGGING;

    static void initialize() {
        INSTANCE = new SteelCore();
        PLATFORM_UTILS = new SteelUtils();
         VERBOSE_LOGGING = SteelMain.getPlugin().getConfig().getBoolean("verbose-logging");
    }

    @Override
    protected Minigame registerPlugin0(String pluginId) throws IllegalArgumentException {
        if (minigames.containsKey(pluginId)) {
            throw new IllegalArgumentException(pluginId + " attempted to register itself more than once");
        }
        Minigame minigame = new SteelMinigame(pluginId);
        minigames.put(pluginId, minigame);
        return minigame;
    }

    @Override
    protected void logInfo0(String message) {
        SteelMain.getPlugin().getLogger().info(message);
    }

    @Override
    protected void logWarning0(String message) {
        SteelMain.getPlugin().getLogger().warning(message);
    }

    @Override
    protected void logSevere0(String message) {
        SteelMain.getPlugin().getLogger().severe(message);
    }

    @Override
    protected void logVerbose0(String message) {
        if (VERBOSE_LOGGING) {
            SteelMain.getPlugin().getLogger().info("[VERBOSE] " + message);
        }
    }

}
