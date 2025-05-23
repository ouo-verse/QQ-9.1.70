package zg4;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.timi.game.emo.ui.TimiEmoPanelView;
import com.tencent.timi.game.emo.ui.panel.fav.FavoritePanelView;
import com.tencent.timi.game.emo.ui.panel.hot.HotPicPanelView;
import com.tencent.timi.game.emo.ui.panel.sys.SystemEmojiPanelView;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xg4.e;
import xg4.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ&\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0011"}, d2 = {"Lzg4/d;", "", "Landroid/content/Context;", "context", "Lxg4/a;", "data", "", com.tencent.luggage.wxa.c8.c.G, "Lbh4/a;", "c", "Lxg4/m;", "param", "Lcom/tencent/timi/game/emo/ui/TimiEmoPanelView;", "a", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f452533a = new d();

    static {
        e.b.f447979b.i();
        l.i("EmoPanelViewProvider_", "EmoPanelViewProvider Favorite.syncFromServer()");
    }

    d() {
    }

    private final bh4.a c(Context context, xg4.a data, int pos) {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, Integer.valueOf(Color.parseColor("#dc8756"))), TuplesKt.to(1, Integer.valueOf(Color.parseColor("#541290"))), TuplesKt.to(2, Integer.valueOf(Color.parseColor("#679012"))), TuplesKt.to(3, Integer.valueOf(Color.parseColor("#ae6721"))), TuplesKt.to(4, Integer.valueOf(Color.parseColor("#999991"))), TuplesKt.to(5, Integer.valueOf(Color.parseColor("#111111"))), TuplesKt.to(6, Integer.valueOf(Color.parseColor(TipsElementData.DEFAULT_COLOR))), TuplesKt.to(7, Integer.valueOf(Color.parseColor("#cccccc"))), TuplesKt.to(8, Integer.valueOf(Color.parseColor("#777777"))), TuplesKt.to(9, Integer.valueOf(Color.parseColor("#333333"))));
        TextView textView = new TextView(context);
        textView.setText("\u3010" + pos + "\u3011" + data);
        Object obj = mapOf.get(Integer.valueOf(pos % mapOf.size()));
        Intrinsics.checkNotNull(obj);
        textView.setBackgroundColor(((Number) obj).intValue());
        return new a(textView);
    }

    @NotNull
    public final TimiEmoPanelView a(@NotNull m param) {
        Intrinsics.checkNotNullParameter(param, "param");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new xg4.a(99L, param.getScene(), R.drawable.o7a, null, 8, null));
        arrayList.add(new xg4.a(1L, param.getScene(), R.drawable.o79, null, 8, null));
        arrayList.add(new xg4.a(2L, param.getScene(), R.drawable.o7_, null, 8, null));
        TimiEmoPanelView timiEmoPanelView = new TimiEmoPanelView(param.getContext(), null, 0, 6, null);
        timiEmoPanelView.setCreateParam(param);
        timiEmoPanelView.setData(arrayList);
        return timiEmoPanelView;
    }

    @NotNull
    public final bh4.a b(@NotNull Context context, @NotNull xg4.a data, int pos, @NotNull m param) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(param, "param");
        long type = data.getType();
        if (type == 99) {
            return new SystemEmojiPanelView(context, null, 0, param, data, 6, null);
        }
        if (type == 1) {
            return new FavoritePanelView(context, null, 0, param, data, 6, null);
        }
        if (type == 2) {
            return new HotPicPanelView(context, null, 0, param, data, pos, 6, null);
        }
        return c(context, data, pos);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"zg4/d$a", "Lbh4/a;", "Landroid/view/View;", "getView", "", "destroy", "a", "", "onBackEvent", "d", "b", "", com.tencent.luggage.wxa.c8.c.G, "onPageSelected", "yesGameId", "g", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements bh4.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f452534d;

        a(TextView textView) {
            this.f452534d = textView;
        }

        @Override // bh4.a
        @Nullable
        public View b() {
            return null;
        }

        @Override // bh4.a
        public boolean d() {
            return false;
        }

        @Override // bh4.a
        @NotNull
        public View getView() {
            return this.f452534d;
        }

        @Override // bh4.a
        public boolean onBackEvent() {
            return false;
        }

        @Override // bh4.a
        public void a() {
        }

        @Override // bh4.a
        public void destroy() {
        }

        @Override // bh4.a
        public void g(int yesGameId) {
        }

        @Override // bh4.a
        public void onPageSelected(int pos) {
        }
    }
}
