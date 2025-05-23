package sf2;

import com.qzone.reborn.intimate.ntcompose.QZIntimateLoveTreeKuiklyExport;
import com.tencent.intimate_space.impl.IntimateSpaceKuiklyExport;
import com.tencent.mobileqq.gamecenter.qa.kuikly.GameQAKuiklyExport;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyExport;
import com.tencent.mobileqq.nearbypro.feeds.publish.kuikly.NBPPublishKuiklyExport;
import com.tencent.mobileqq.nearbypro.profile.kuikly.NearbyProfileKuiklyExport;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e;
import com.tencent.mobileqq.qqlive.kuikly.QQLiveKuiklyExport;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.robot.adelie.kuikly.AdelieKuiklyExport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R6\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u00078\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u0012\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lsf2/a;", "", "", "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/e;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getInjectList$annotations", "()V", "injectList", "", "c", "Ljava/util/List;", "exportList", "", "d", "Z", "hadInit", "", "a", "()Ljava/util/List;", Constants.Raft.EXPORTS, "<init>", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f433766a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQKuikly/Inject_Kuikly_Export.yml", version = 1)
    private static final ArrayList<Class<e>> injectList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final List<e> exportList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean hadInit;

    static {
        ArrayList<Class<e>> arrayList = new ArrayList<>();
        injectList = arrayList;
        arrayList.add(NearbyProfileKuiklyExport.class);
        arrayList.add(NBPPublishKuiklyExport.class);
        arrayList.add(GameQAKuiklyExport.class);
        arrayList.add(MiniGameKuiklyExport.class);
        arrayList.add(QQLiveKuiklyExport.class);
        arrayList.add(AdelieKuiklyExport.class);
        arrayList.add(IntimateSpaceKuiklyExport.class);
        arrayList.add(QZIntimateLoveTreeKuiklyExport.class);
        exportList = new ArrayList();
    }

    a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b() {
        Iterator<T> it = injectList.iterator();
        while (it.hasNext()) {
            Class cls = (Class) it.next();
            List<e> list = exportList;
            Object newInstance = cls.newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "it.newInstance()");
            list.add(newInstance);
        }
    }

    public final List<e> a() {
        if (!hadInit) {
            b();
            hadInit = true;
        }
        return exportList;
    }
}
