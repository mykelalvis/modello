package org.codehaus.modello.core;

/*
 * Copyright (c) 2004, Codehaus.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.Map;

import org.codehaus.modello.ModelloRuntimeException;
import org.codehaus.modello.metadata.MetadataPlugin;
import org.codehaus.modello.plugin.AbstractPluginManager;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;

/**
 * @author <a href="mailto:trygvis@inamo.no">Trygve Laugst&oslash;l</a>
 */
@Component(role = MetadataPluginManager.class)
public class DefaultMetadataPluginManager extends AbstractPluginManager<MetadataPlugin>
        implements MetadataPluginManager {
    @Requirement
    private Map<String, MetadataPlugin> plugins;

    public Map<String, MetadataPlugin> getPlugins() {
        return plugins;
    }

    public MetadataPlugin getMetadataPlugin(String metadataId) {
        MetadataPlugin metadata = getPlugin(metadataId);

        if (metadata == null) {
            throw new ModelloRuntimeException("No such metadata plugin: '" + metadataId + "'.");
        }

        return metadata;
    }

    public boolean hasMetadataPlugin(String metadataId) {
        return hasPlugin(metadataId);
    }
}
