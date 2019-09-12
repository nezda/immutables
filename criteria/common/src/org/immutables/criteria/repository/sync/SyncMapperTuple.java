/*
 * Copyright 2019 Immutables Authors and Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.immutables.criteria.repository.sync;

import org.immutables.criteria.backend.Backend;
import org.immutables.criteria.expression.Query;
import org.immutables.criteria.repository.Tuple;
import org.immutables.criteria.repository.reactive.ReactiveMapperTuple;

import java.util.function.Function;

public class SyncMapperTuple {

  private final ReactiveMapperTuple delegate;

  SyncMapperTuple(Query query, Backend.Session session) {
    this.delegate = new ReactiveMapperTuple(query, session);
  }

  public <R> SyncFetcher<R> map(Function<? super Tuple, ? extends R> mapFn) {
    return SyncFetcherDelegate.fromReactive(delegate.map(mapFn));
  }
}
