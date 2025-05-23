package tencent.im.oidb.cmd0xb31;

import com.tencent.luggage.wxa.uf.l;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb31$RspBody extends MessageMicro<oidb_0xb31$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, l.CTRL_INDEX, 800}, new String[]{"items", "fromuin", "touin"}, new Object[]{null, 0L, 0L}, oidb_0xb31$RspBody.class);
    public final PBRepeatMessageField<oidb_0xb31$SimilarItem> items = PBField.initRepeatMessage(oidb_0xb31$SimilarItem.class);
    public final PBUInt64Field fromuin = PBField.initUInt64(0);
    public final PBUInt64Field touin = PBField.initUInt64(0);
}
