package tm1;

import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.EditorInstanceStateTranslator;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.f;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.g;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.h;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.i;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.j;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.l;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text.TextContentTranslator;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0005B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\u0011"}, d2 = {"Ltm1/d;", "Ltm1/b;", "Lnm1/b;", "translateInfo", "Lorg/json/JSONObject;", "a", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/e;", "Ljava/util/List;", "mTranslatorList", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/i;", "transparentJsonTranslator", "", "extendedTranslators", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/i;[Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/e;)V", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e> mTranslatorList;

    public d(@NotNull i transparentJsonTranslator, @NotNull com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e[] extendedTranslators) {
        List<com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e> listOf;
        Intrinsics.checkNotNullParameter(transparentJsonTranslator, "transparentJsonTranslator");
        Intrinsics.checkNotNullParameter(extendedTranslators, "extendedTranslators");
        SpreadBuilder spreadBuilder = new SpreadBuilder(16);
        spreadBuilder.add(new com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.d());
        spreadBuilder.add(new l());
        spreadBuilder.add(new f());
        spreadBuilder.add(new com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.a());
        spreadBuilder.add(new j());
        spreadBuilder.add(new h());
        spreadBuilder.add(new TextContentTranslator());
        spreadBuilder.add(new um1.d());
        spreadBuilder.add(new um1.c());
        spreadBuilder.add(new g());
        spreadBuilder.add(new sm1.b());
        spreadBuilder.add(new com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.c());
        spreadBuilder.add(transparentJsonTranslator);
        spreadBuilder.add(new EditorInstanceStateTranslator());
        spreadBuilder.addSpread(extendedTranslators);
        spreadBuilder.add(new com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.b());
        listOf = CollectionsKt__CollectionsKt.listOf(spreadBuilder.toArray(new com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e[spreadBuilder.size()]));
        this.mTranslatorList = listOf;
    }

    @Override // tm1.a
    @NotNull
    public JSONObject a(@NotNull nm1.b translateInfo) {
        String str;
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        try {
            com.tencent.base.api.runtime.a<zl1.a> a16 = translateInfo.a();
            if (a16 != null) {
                str = com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a(a16);
            } else {
                str = null;
            }
            QLog.d("TranslateToPublishTool", 1, "[translate]: taskId=" + str + ", text.length=" + translateInfo.getEditable().length() + ", mediaList.size=" + translateInfo.c().size());
            JSONObject jSONObject = new JSONObject();
            Iterator<T> it = this.mTranslatorList.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e) it.next()).a(jSONObject, translateInfo);
            }
            return jSONObject;
        } catch (Exception e16) {
            QLog.d("TranslateToPublishTool", 1, "translate error! " + e16);
            return new JSONObject();
        }
    }
}
