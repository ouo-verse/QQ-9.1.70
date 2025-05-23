package zx4;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J6\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H&J&\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\t0\fH&J\"\u0010\u0010\u001a\u00020\t2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f\u0012\u0004\u0012\u00020\t0\fH&J<\u0010\u0013\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2$\u0010\r\u001a \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00120\u000f\u0012\u0004\u0012\u00020\t0\fH&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0004H&J \u0010\u001a\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0004H&J6\u0010\u001e\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H&J:\u0010\u001f\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\t0\fH&J:\u0010 \u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\t0\fH&J@\u0010#\u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0016\u001a\u00020\u00042 \u0010\r\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017\u0018\u00010\"\u0012\u0004\u0012\u00020\t0\fH&J\u0018\u0010&\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0004H&\u00a8\u0006'"}, d2 = {"Lzx4/e;", "", "", "maxSelectNum", "", "templateID", "", "preselection", "preselectionSex", "", "k", "uin", "Lkotlin/Function1;", "cb", tl.h.F, "", "j", "genderList", "Lkotlin/Pair;", "g", "path", "i", "appId", "", "isSupportMultiSelect", "arkShareContent", "a", "openId", "sourceId", "subSourceId", "c", "b", "d", "openIdList", "", "f", "scene", "imagePath", "e", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface e {
    void a(@NotNull String appId, boolean isSupportMultiSelect, @NotNull String arkShareContent);

    void b(@Nullable String uin, @Nullable String openId, @Nullable String appId, @NotNull Function1<? super Boolean, Unit> cb5);

    void c(@Nullable String uin, @Nullable String openId, @Nullable String appId, int sourceId, int subSourceId);

    void d(@Nullable String uin, @Nullable String openId, @Nullable String appId, @NotNull Function1<? super Boolean, Unit> cb5);

    void e(int scene, @NotNull String imagePath);

    void f(@NotNull List<String> openIdList, @NotNull String appId, @NotNull Function1<? super Map<String, Boolean>, Unit> cb5);

    void g(@NotNull List<Integer> genderList, @NotNull Function1<? super List<Pair<String, String>>, Unit> cb5);

    void h(@NotNull String uin, @NotNull Function1<? super String, Unit> cb5);

    void i(@NotNull String path);

    void j(@NotNull Function1<? super List<String>, Unit> cb5);

    void k(int maxSelectNum, @Nullable String templateID, @NotNull List<String> preselection, @NotNull List<Integer> preselectionSex);
}
