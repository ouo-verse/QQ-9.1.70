package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounterStyle$StyleTab extends MessageMicro<QQCircleCounterStyle$StyleTab> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"bubble", "button", "red", "playSecond", "mod"}, new Object[]{null, null, null, 0, 0}, QQCircleCounterStyle$StyleTab.class);
    public QQCircleCounterStyle$StyleBubble bubble = new QQCircleCounterStyle$StyleBubble();
    public QQCircleCounterStyle$StyleTabButton button = new QQCircleCounterStyle$StyleTabButton();
    public QQCircleCounterStyle$StyleRed red = new QQCircleCounterStyle$StyleRed();
    public final PBInt32Field playSecond = PBField.initInt32(0);
    public final PBEnumField mod = PBField.initEnum(0);
}
