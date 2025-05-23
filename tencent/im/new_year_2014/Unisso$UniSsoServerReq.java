package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Unisso$UniSsoServerReq extends MessageMicro<Unisso$UniSsoServerReq> {
    public static final int COMM_FIELD_NUMBER = 1;
    public static final int REQDATA_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"comm", "reqdata"}, new Object[]{null, ByteStringMicro.EMPTY}, Unisso$UniSsoServerReq.class);
    public Unisso$UniSsoServerReqComm comm = new Unisso$UniSsoServerReqComm();
    public final PBBytesField reqdata = PBField.initBytes(ByteStringMicro.EMPTY);
}
