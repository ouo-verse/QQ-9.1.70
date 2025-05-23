package u23;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.TextGiftElement;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lu23/a;", "Lcom/tencent/qqnt/chats/inject/summary/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "Landroid/view/View;", "view", "", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a extends com.tencent.qqnt.chats.inject.summary.a {
    private final String b(g item) {
        boolean z16;
        boolean z17;
        BaseQQAppInterface baseQQAppInterface;
        ArrayList<MsgAbstractElement> arrayList = item.s().abstractContent;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MsgAbstractElement msgAbstractElement = (MsgAbstractElement) it.next();
                int i3 = msgAbstractElement.elementType;
                if (i3 == 10 || i3 == 18) {
                    TextGiftElement textGiftElement = msgAbstractElement.textGiftElement;
                    if (textGiftElement != null) {
                        Intrinsics.checkNotNullExpressionValue(textGiftElement, "textGiftElement");
                        String str = textGiftElement.senderNick;
                        boolean z18 = false;
                        if (str != null && str.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            String str2 = textGiftElement.receiverNick;
                            if (str2 != null && str2.length() != 0) {
                                z17 = false;
                            } else {
                                z17 = true;
                            }
                            if (!z17) {
                                String str3 = textGiftElement.giftName;
                                if (str3 == null || str3.length() == 0) {
                                    z18 = true;
                                }
                                if (!z18) {
                                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                    if (peekAppRuntime instanceof BaseQQAppInterface) {
                                        baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
                                    } else {
                                        baseQQAppInterface = null;
                                    }
                                    if (baseQQAppInterface == null) {
                                        return null;
                                    }
                                    String str4 = textGiftElement.senderNick + "\uff1a\u9001" + textGiftElement.giftName + "\u7ed9" + textGiftElement.receiverNick;
                                    if (Intrinsics.areEqual(String.valueOf(textGiftElement.receiverUin), baseQQAppInterface.getCurrentUin())) {
                                        return textGiftElement.senderNick + "\uff1a\u9001" + textGiftElement.giftName + "\u7ed9\u6211";
                                    }
                                    return str4;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.chats.inject.summary.a
    public void a(@NotNull g item, @NotNull View view) {
        com.tencent.qqnt.chats.view.a aVar;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        String b16 = b(item);
        if (b16 != null) {
            item.v().l(b16);
            if (view instanceof com.tencent.qqnt.chats.view.a) {
                aVar = (com.tencent.qqnt.chats.view.a) view;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.setSummaryContent(item.v().f());
            }
        }
    }
}
