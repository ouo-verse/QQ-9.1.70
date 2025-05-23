package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$NeedShowEntranceRsp extends MessageMicro<QZIntimateProfileReader$NeedShowEntranceRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"show_sweet_entrance"}, new Object[]{Boolean.FALSE}, QZIntimateProfileReader$NeedShowEntranceRsp.class);
    public final PBBoolField show_sweet_entrance = PBField.initBool(false);
}
