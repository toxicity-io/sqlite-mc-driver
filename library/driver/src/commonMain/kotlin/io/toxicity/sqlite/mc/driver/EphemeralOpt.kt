/*
 * Copyright (c) 2023 Toxicity
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package io.toxicity.sqlite.mc.driver

public sealed class EphemeralOpt {

    /**
     * Creates a purely in-memory database using `":memory:"`
     * as the SQLite path.
     * */
    public object InMemory: EphemeralOpt()

    /**
     * Creates a named in-memory database using
     * `file:{dbName}?mode=memory&cache=shared` as the
     * SQLite path.
     *
     * NOTE: A named in-memory database will stay open
     * until **all** connections with it are closed.
     * */
    public object Named: EphemeralOpt()

    /**
     * Creates a temporary database using `""` (an empty value)
     * as the SQLite path.
     *
     * NOTE: A Temporary database differs from [InMemory] in that
     * it remains mostly in-memory, but SQLite will dump data to
     * a temp file when needed. The temp file is deleted upon
     * connection closure.
     * */
    public object Temporary: EphemeralOpt()
}