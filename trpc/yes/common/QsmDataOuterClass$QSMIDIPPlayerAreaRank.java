package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes30.dex */
public final class QsmDataOuterClass$QSMIDIPPlayerAreaRank extends MessageMicro<QsmDataOuterClass$QSMIDIPPlayerAreaRank> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"rank", "percent"}, new Object[]{0, 0}, QsmDataOuterClass$QSMIDIPPlayerAreaRank.class);
    public final PBUInt32Field rank = PBField.initUInt32(0);
    public final PBUInt32Field percent = PBField.initUInt32(0);
}
