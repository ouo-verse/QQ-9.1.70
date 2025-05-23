package yx3;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.j;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: yx3.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC11637a {
        void a(List<j> list);

        void j(boolean z16, @Nullable j jVar);
    }

    void asyncGetSearchHistoryData(InterfaceC11637a interfaceC11637a);

    void deleteHistory(j jVar);

    void destroy();

    void doSearchHistoryAction(Context context, int i3, int i16, j jVar);

    void init(AppInterface appInterface, Context context);
}
