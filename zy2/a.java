package zy2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.DittoTextAreaCompat;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.uihierarchy.TextViewCompat;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f453715b = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "/qq_uidump.xml";

    /* renamed from: a, reason: collision with root package name */
    private final XmlSerializer f453716a = Xml.newSerializer();

    /* JADX WARN: Multi-variable type inference failed */
    private void a(View view) throws Exception {
        String valueOf;
        String str;
        char c16;
        String str2;
        if (view == 0 || view.getVisibility() != 0) {
            return;
        }
        Resources resources = view.getResources();
        if (view.getId() > 0) {
            try {
                valueOf = resources.getResourceEntryName(view.getId());
            } catch (Throwable unused) {
                valueOf = String.valueOf(view.getId());
            }
        } else {
            valueOf = String.valueOf(view.getId());
        }
        String name = view.getClass().getName();
        String c17 = c(view.getContentDescription());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        Rect rect = new Rect(i3, i16, view.getMeasuredWidth() + i3, view.getMeasuredHeight() + i16);
        String format = String.format("[%s,%s][%s,%s]", Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom));
        if (view instanceof TextView) {
            str = c(((TextView) view).getText());
        } else if (!(view instanceof TextViewCompat)) {
            str = "";
        } else {
            str = c(((TextViewCompat) view).getText());
        }
        Context context = view.getContext();
        Rect rect2 = new Rect(e(context, rect.left), e(context, rect.top), e(context, rect.right), e(context, rect.bottom));
        String format2 = String.format("(%s,%s,%s,%s) %s-%s", Integer.valueOf(rect2.left), Integer.valueOf(rect2.top), Integer.valueOf(rect2.right), Integer.valueOf(rect2.bottom), Integer.valueOf(rect2.width()), Integer.valueOf(rect2.height()));
        String format3 = String.format("[%s,%s][%s,%s]", Integer.valueOf(e(context, view.getPaddingLeft())), Integer.valueOf(e(context, view.getPaddingTop())), Integer.valueOf(e(context, view.getPaddingRight())), Integer.valueOf(e(context, view.getPaddingBottom())));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            c16 = 3;
            str2 = String.format("[%s,%s][%s,%s]", Integer.valueOf(e(context, marginLayoutParams.leftMargin)), Integer.valueOf(e(context, marginLayoutParams.topMargin)), Integer.valueOf(e(context, marginLayoutParams.rightMargin)), Integer.valueOf(e(context, marginLayoutParams.bottomMargin)));
        } else {
            c16 = 3;
            str2 = "[0,0][0,0]";
        }
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = format2;
        objArr[2] = format3;
        objArr[c16] = str2;
        objArr[4] = Float.valueOf(view.getAlpha());
        String format4 = String.format("text=%s, bounds(dp)=%s, paddings(dp)=%s, margins(dp)=%s, alpha=%s", objArr);
        this.f453716a.startTag("", "node");
        this.f453716a.attribute("", "resource-id", valueOf);
        this.f453716a.attribute("", Constants.Service.CLASS, name);
        this.f453716a.attribute("", "package", "com.tencent.mobileqq");
        this.f453716a.attribute("", "content-desc", c17);
        this.f453716a.attribute("", "clickable", String.valueOf(view.isClickable()));
        this.f453716a.attribute("", NodeProps.ENABLED, String.valueOf(view.isEnabled()));
        this.f453716a.attribute("", NodeProps.FOCUSABLE, String.valueOf(view.isFocusable()));
        this.f453716a.attribute("", "long-clickable", String.valueOf(view.isLongClickable()));
        this.f453716a.attribute("", "selected", String.valueOf(view.isSelected()));
        this.f453716a.attribute("", "bounds", format);
        this.f453716a.attribute("", "text", format4);
        this.f453716a.attribute("", "index", "0");
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                a(viewGroup.getChildAt(i17));
            }
        } else if (view instanceof DittoAreaView) {
            Rect rect3 = new Rect();
            rect3.left = rect.left + view.getPaddingLeft();
            rect3.top = rect.top + view.getPaddingTop();
            rect3.right = rect.right - view.getPaddingRight();
            rect3.bottom = rect.bottom + view.getPaddingBottom();
            b(((DittoAreaView) view).getCanvasArea(), rect3);
        }
        this.f453716a.endTag("", "node");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(DittoArea dittoArea, Rect rect) throws Exception {
        String str;
        if (dittoArea == 0 || dittoArea.getVisibility() != 0) {
            return;
        }
        String c16 = c(dittoArea.getId());
        String name = dittoArea.getClass().getName();
        String c17 = c(dittoArea.getContentDescription());
        if (rect == null) {
            rect = new Rect();
        }
        int left = rect.left + dittoArea.getLeft();
        int top = rect.top + dittoArea.getTop();
        Rect rect2 = new Rect(left, top, dittoArea.getMeasuredWidth() + left, dittoArea.getMeasuredHeight() + top);
        String format = String.format("[%s,%s][%s,%s]", Integer.valueOf(rect2.left), Integer.valueOf(rect2.top), Integer.valueOf(rect2.right), Integer.valueOf(rect2.bottom));
        if (dittoArea instanceof DittoTextArea) {
            str = c(((DittoTextArea) dittoArea).getText());
        } else if (!(dittoArea instanceof DittoTextAreaCompat)) {
            str = "";
        } else {
            str = c(((DittoTextAreaCompat) dittoArea).getText());
        }
        this.f453716a.startTag("", "node");
        this.f453716a.attribute("", "resource-id", c16);
        this.f453716a.attribute("", Constants.Service.CLASS, name);
        this.f453716a.attribute("", "package", "com.tencent.mobileqq");
        this.f453716a.attribute("", "content-desc", c17);
        this.f453716a.attribute("", "bounds", format);
        this.f453716a.attribute("", "text", str);
        this.f453716a.attribute("", "index", "0");
        if (dittoArea instanceof DittoAreaGroup) {
            DittoAreaGroup dittoAreaGroup = (DittoAreaGroup) dittoArea;
            Rect rect3 = new Rect();
            rect3.left = rect2.left + dittoAreaGroup.getPaddingLeft();
            rect3.top = rect2.top + dittoAreaGroup.getPaddingTop();
            rect3.right = rect2.right - dittoAreaGroup.getPaddingRight();
            rect3.bottom = rect2.bottom + dittoAreaGroup.getPaddingBottom();
            int childCount = dittoAreaGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                b(dittoAreaGroup.getChildAt(i3), rect3);
            }
        }
        this.f453716a.endTag("", "node");
    }

    private String c(CharSequence charSequence) throws Exception {
        if (charSequence == null) {
            return "";
        }
        String charSequence2 = charSequence.toString();
        if (d(charSequence2)) {
            return charSequence2;
        }
        return "invalid character!";
    }

    private boolean d(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= length) {
                return true;
            }
            char c16 = charArray[i3];
            if ((c16 < ' ' || c16 > '\ud7ff') && c16 != '\t' && c16 != '\n' && c16 != '\r' && (c16 < '\ue000' || c16 > '\ufffd')) {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            i3++;
        }
    }

    private static int e(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void f(View view) throws Exception {
        this.f453716a.startTag("", "hierarchy");
        a(view);
        this.f453716a.endTag("", "hierarchy");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.FileWriter, java.io.Writer] */
    public void g(View view) {
        ?? fileWriter;
        if (view == null) {
            return;
        }
        StringWriter stringWriter = null;
        try {
            StringWriter stringWriter2 = new StringWriter();
            try {
                this.f453716a.setOutput(stringWriter2);
                this.f453716a.startDocument("utf-8", null);
                f(view);
                this.f453716a.endDocument();
                String stringWriter3 = stringWriter2.toString();
                try {
                    fileWriter = new FileWriter(new File(f453715b));
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    fileWriter.write(stringWriter3);
                    try {
                        fileWriter.close();
                    } catch (IOException e16) {
                        QLog.e("UiHierarchyHelper", 2, e16, new Object[0]);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    stringWriter = fileWriter;
                    try {
                        QLog.e("UiHierarchyHelper", 2, th, new Object[0]);
                        if (stringWriter != null) {
                            try {
                                stringWriter.close();
                            } catch (IOException e17) {
                                QLog.e("UiHierarchyHelper", 2, e17, new Object[0]);
                            }
                        }
                        stringWriter2.close();
                    } finally {
                    }
                }
                try {
                    stringWriter2.close();
                } catch (IOException e18) {
                    QLog.e("UiHierarchyHelper", 2, e18, new Object[0]);
                }
            } catch (Throwable th7) {
                th = th7;
                stringWriter = stringWriter2;
                try {
                    QLog.e("UiHierarchyHelper", 2, th, new Object[0]);
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (IOException e19) {
                            QLog.e("UiHierarchyHelper", 2, e19, new Object[0]);
                        }
                    }
                } catch (Throwable th8) {
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (IOException e26) {
                            QLog.e("UiHierarchyHelper", 2, e26, new Object[0]);
                        }
                    }
                    throw th8;
                }
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }
}
