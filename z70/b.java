package z70;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.immersive.manager.e;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements IOrderElement {
    private final Set<View> C;
    private final Set<Toast> D;
    private final Set<PopupWindow> E;
    private final Set<com.tencent.biz.qqcircle.widgets.comment.a> F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private final String f452117d;

    /* renamed from: e, reason: collision with root package name */
    private final View f452118e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f452119f;

    /* renamed from: h, reason: collision with root package name */
    private final int f452120h;

    /* renamed from: i, reason: collision with root package name */
    private final String f452121i;

    /* renamed from: m, reason: collision with root package name */
    private final int f452122m;

    public b(Context context, String str, int i3) {
        this(null, context, str, i3);
    }

    private void f(int i3) {
        try {
            for (com.tencent.biz.qqcircle.widgets.comment.a aVar : this.F) {
                if (aVar != null) {
                    QLog.d(this.f452117d, 1, "[dealWithDialogVisibility] dialog" + aVar + ", visible:" + i3);
                    if (i3 == 8) {
                        if (aVar.isShowing()) {
                            aVar.N();
                        }
                    } else {
                        aVar.O();
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(this.f452117d, 1, "[dealWithDialogVisibility] e:" + e16);
            if (!HostAppSettingUtil.isDebugVersion()) {
                return;
            }
            throw new RuntimeException("[dealWithDialogVisibility]  error:" + e16);
        }
    }

    public static b g(List<IOrderElement> list, int i3) {
        if (list == null) {
            return null;
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            IOrderElement iOrderElement = list.get(i16);
            if (iOrderElement != null && iOrderElement.getPriority() == i3) {
                if (iOrderElement instanceof b) {
                    return (b) iOrderElement;
                }
                QLog.e("QFSOrderElementWrapper", 1, "[getElementByPriority] but type not equals " + iOrderElement);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Toast toast) {
        this.D.remove(toast);
    }

    private void n(int i3) {
        for (View view : this.C) {
            if (view != null) {
                QLog.d(this.f452117d, 1, "[setLowPriorityViewVisibility] " + view + ", visible:" + i3);
                view.setVisibility(i3);
            }
        }
        for (PopupWindow popupWindow : this.E) {
            if (popupWindow != null) {
                QLog.d(this.f452117d, 1, "[setLowPriorityWindowVisibility] " + popupWindow + ", visible:" + i3);
                o(popupWindow, i3);
            }
        }
        for (Toast toast : this.D) {
            if (toast != null) {
                QLog.d(this.f452117d, 1, "[setLowPriorityViewVisibility] toast" + toast + ", visible:" + i3);
                if (i3 == 8) {
                    toast.cancel();
                } else {
                    toast.show();
                }
                this.D.remove(toast);
            }
        }
        f(i3);
    }

    private void o(PopupWindow popupWindow, int i3) {
        View contentView;
        if (popupWindow != null && (contentView = popupWindow.getContentView()) != null) {
            contentView.setVisibility(i3);
        }
    }

    public void b(View view) {
        if (view == null) {
            return;
        }
        this.C.add(view);
        QLog.d(this.f452117d, 1, "[addLowPriorityView] view: " + view + ", mIsShowing:" + this.G);
        if (this.G) {
            view.setVisibility(8);
        }
    }

    public void c(PopupWindow popupWindow) {
        if (popupWindow == null) {
            return;
        }
        QLog.d(this.f452117d, 2, "[addLowPriorityWindow] window: " + popupWindow + ", mIsShowing:" + this.G);
        this.E.add(popupWindow);
        if (this.G) {
            o(popupWindow, 8);
        }
    }

    public void d(final Toast toast, long j3) {
        long j16;
        if (toast == null) {
            return;
        }
        QLog.d(this.f452117d, 2, "[registerLowPriorityToast] toast: " + toast + ", mIsShowing:" + this.G + "\uff0cduration\uff1a" + j3);
        if (this.G) {
            this.D.add(toast);
            toast.cancel();
            return;
        }
        this.D.add(toast);
        if (j3 == 0) {
            j16 = 2000;
        } else {
            j16 = 3500;
        }
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: z70.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.h(toast);
            }
        }, j16);
    }

    public void e(com.tencent.biz.qqcircle.widgets.comment.a aVar) {
        if (aVar == null) {
            return;
        }
        QLog.d(this.f452117d, 2, "[addLowPriorityDialog] dialog: " + aVar + ", mIsShowing:" + this.G);
        this.F.add(aVar);
        if (this.G) {
            aVar.N();
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        return String.valueOf(this.f452120h);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return this.f452121i;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return com.tencent.biz.richframework.order.a.b(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return this.f452122m;
    }

    public void i(View view) {
        if (view == null) {
            return;
        }
        this.C.remove(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return this.f452119f;
    }

    public void j(PopupWindow popupWindow) {
        if (popupWindow == null) {
            return;
        }
        QLog.d(this.f452117d, 2, "[removeLowPriorityView] window: " + popupWindow + ", mIsShowing:" + this.G);
        this.E.remove(popupWindow);
    }

    public void k(com.tencent.biz.qqcircle.widgets.comment.a aVar) {
        if (aVar == null) {
            return;
        }
        QLog.d(this.f452117d, 2, "[removeLowPriorityDialog] dialog: " + aVar + ", mIsShowing:" + this.G);
        this.F.remove(aVar);
    }

    public void l(RFWOrderElementManager.OrderMode orderMode) {
        this.f452119f = true;
        QLog.d(this.f452117d, 1, "[setCanShow] mode: " + orderMode);
        e.a().notifyGroupActivate(this, orderMode);
    }

    public void m() {
        this.f452119f = false;
        QLog.d(this.f452117d, 1, "[setInActive]");
        e.a().inactivateElement(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        QLog.d(this.f452117d, 1, "[onElementActivated] ");
        this.G = true;
        View view = this.f452118e;
        if (view != null) {
            view.setVisibility(0);
        }
        n(8);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        QLog.d(this.f452117d, 1, "[onElementInactivated] ");
        this.G = false;
        View view = this.f452118e;
        if (view != null) {
            view.setVisibility(8);
        }
        n(0);
    }

    public String toString() {
        return this.f452117d;
    }

    public b(View view, Context context, String str, int i3) {
        this.C = new CopyOnWriteArraySet();
        this.D = new CopyOnWriteArraySet();
        this.E = new CopyOnWriteArraySet();
        this.F = new CopyOnWriteArraySet();
        this.f452117d = "QFSOrderElementWrapper_" + str + "_" + i3;
        this.f452118e = view;
        if (context != null) {
            this.f452120h = context.hashCode();
        } else {
            this.f452120h = -1;
        }
        this.f452121i = str;
        this.f452122m = i3;
    }
}
