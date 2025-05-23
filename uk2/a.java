package uk2;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Luk2/a;", "Lcom/tencent/mobileqq/tianshu/data/BusinessInfoCheckUpdateItem$DynamicRedPointPathInterface;", "Lmqq/app/AppRuntime;", "appInterface", "", "", "getRedPointPaths", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface {
    @Override // com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
    @NotNull
    public List<String> getRedPointPaths(@Nullable AppRuntime appInterface) {
        List<String> mutableListOf;
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("140126", "140126.140126001");
            return mutableListOf;
        }
        return new ArrayList();
    }
}
