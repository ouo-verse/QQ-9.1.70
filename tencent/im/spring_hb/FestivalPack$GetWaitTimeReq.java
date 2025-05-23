package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes29.dex */
public final class FestivalPack$GetWaitTimeReq extends MessageMicro<FestivalPack$GetWaitTimeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"addr_code"}, new Object[]{0L}, FestivalPack$GetWaitTimeReq.class);
    public final PBInt64Field addr_code = PBField.initInt64(0);
}
