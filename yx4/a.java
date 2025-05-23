package yx4;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wx4.PrepareAssetsStatistic;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J8\u0010\f\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH&J\u001c\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003H&\u00a8\u0006\u0011"}, d2 = {"Lyx4/a;", "", "", "", "Lcom/tencent/zplan/meme/model/a;", "avatarCharacters", "", "Ljx4/b;", "stickerConfigList", "Lwx4/e;", "statistic", "", "onSuccess", "", "errorCode", "errorMessage", "onFail", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {
    void onFail(int errorCode, @Nullable String errorMessage);

    void onSuccess(@Nullable Map<String, com.tencent.zplan.meme.model.a> avatarCharacters, @Nullable List<jx4.b> stickerConfigList, @NotNull PrepareAssetsStatistic statistic);
}
