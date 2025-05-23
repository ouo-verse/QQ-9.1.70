package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_mgr$HwQueryCardRsp extends MessageMicro<group_mgr$HwQueryCardRsp> {
    public static final int CARD_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"card_info"}, new Object[]{null}, group_mgr$HwQueryCardRsp.class);
    public group_mgr$CardInfo card_info = new group_mgr$CardInfo();
}
