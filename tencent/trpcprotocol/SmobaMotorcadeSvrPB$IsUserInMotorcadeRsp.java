package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class SmobaMotorcadeSvrPB$IsUserInMotorcadeRsp extends MessageMicro<SmobaMotorcadeSvrPB$IsUserInMotorcadeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_in_motorcade"}, new Object[]{Boolean.FALSE}, SmobaMotorcadeSvrPB$IsUserInMotorcadeRsp.class);
    public final PBBoolField is_in_motorcade = PBField.initBool(false);
}
