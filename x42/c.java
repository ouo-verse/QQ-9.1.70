package x42;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private RecyclerView f447181a;

    /* renamed from: b, reason: collision with root package name */
    private b f447182b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            int itemCount = recyclerView.getAdapter().getItemCount();
            LinearLayoutManager d16 = c.this.d(recyclerView);
            if (d16 == null) {
                return;
            }
            if (d16.findFirstCompletelyVisibleItemPosition() == 0) {
                c.this.f447182b.c();
            } else {
                c.this.f447182b.a();
            }
            if (d16.findLastCompletelyVisibleItemPosition() == itemCount - 1) {
                c.this.f447182b.b();
            } else {
                c.this.f447182b.d();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LinearLayoutManager d(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        }
        return null;
    }

    private void e() {
        this.f447181a.addOnScrollListener(new a());
    }

    public void c(RecyclerView recyclerView, b bVar) {
        this.f447181a = recyclerView;
        this.f447182b = bVar;
        e();
    }

    /* compiled from: P */
    /* renamed from: x42.c$c, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C11529c implements b {
        @Override // x42.c.b
        public void a() {
        }

        @Override // x42.c.b
        public void b() {
        }

        @Override // x42.c.b
        public void c() {
        }

        @Override // x42.c.b
        public void d() {
        }
    }
}
