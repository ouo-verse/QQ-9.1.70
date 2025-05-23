package xd;

import com.qzonex.utils.richtext.element.TopicElement;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"", "Lcom/qzonex/utils/richtext/element/TopicElement;", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    public static final TopicElement a(String str) {
        int indexOf$default;
        int indexOf$default2;
        int indexOf$default3;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "{topic:", 0, false, 6, (Object) null);
            int i3 = indexOf$default + 7;
            indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, ",url:", 0, false, 6, (Object) null);
            if (i3 != -1 && indexOf$default2 != -1) {
                TopicElement topicElement = new TopicElement();
                String substring = str.substring(i3, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                topicElement.setTopic(substring);
                QLog.i("getTopicElement", 1, "topic is " + topicElement.getTopic());
                indexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) str, ",url:", 0, false, 6, (Object) null);
                int i16 = indexOf$default3 + 5;
                if (i16 == -1) {
                    return new TopicElement();
                }
                String substring2 = str.substring(i16, str.length() - 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                topicElement.setUrl(substring2);
                QLog.i("getTopicElement", 1, "url is " + topicElement.getUrl());
                return topicElement;
            }
            return new TopicElement();
        } catch (Exception e16) {
            QLog.e("getTopicElement", 1, "exception is " + e16);
            return null;
        }
    }
}
