package yf2;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zf2.MessageSettingItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lyf2/a;", "", "", "Lzf2/c;", QCircleDaTongConstant.ElementParamValue.SETTINGS, "", "b", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "type", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "status", "c", "", "a", "Ljava/util/List;", "_settings", "()Ljava/util/List;", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<MessageSettingItem> _settings = new ArrayList();

    public final List<MessageSettingItem> a() {
        List<MessageSettingItem> list;
        list = CollectionsKt___CollectionsKt.toList(this._settings);
        return list;
    }

    public final void b(List<MessageSettingItem> settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        this._settings.clear();
        this._settings.addAll(settings);
    }

    public final void c(MessageType type, e status) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(status, "status");
        int size = this._settings.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (Intrinsics.areEqual(this._settings.get(i3).getType(), type) && !Intrinsics.areEqual(this._settings.get(i3).getStatus(), status)) {
                List<MessageSettingItem> list = this._settings;
                list.set(i3, MessageSettingItem.b(list.get(i3), null, status, 1, null));
            }
        }
    }
}
