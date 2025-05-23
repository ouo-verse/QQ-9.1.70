package vd3;

import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lvd3/d;", "Lvd3/b;", "Lvd3/a;", "preparer", "b", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lorg/json/JSONObject;", "enterJson", "Lvd3/c;", "callback", "", "a", "Lvd3/a;", "firstPreparer", "currentPreparer", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private a firstPreparer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private a currentPreparer;

    @Override // vd3.b
    public void a(ZootopiaEnterParams enterParams, JSONObject enterJson, c callback) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(enterJson, "enterJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = this.firstPreparer;
        if (aVar != null) {
            aVar.a(enterParams, enterJson, callback);
        }
    }

    public final d b(a preparer) {
        Intrinsics.checkNotNullParameter(preparer, "preparer");
        if (this.firstPreparer == null) {
            this.firstPreparer = preparer;
            this.currentPreparer = preparer;
        } else {
            a aVar = this.currentPreparer;
            if (aVar != null) {
                aVar.i(preparer);
            }
            this.currentPreparer = preparer;
        }
        return this;
    }
}
