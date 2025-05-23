package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes29.dex */
public final class GetLocalPhone$OIDBGetPhoneRsp extends MessageMicro<GetLocalPhone$OIDBGetPhoneRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"msg_mask_phone_data", "msg_encrypt_phone_data", "msg_guid_change_mibao_data", "msg_auth_device_succed_data"}, new Object[]{null, null, null, null}, GetLocalPhone$OIDBGetPhoneRsp.class);
    public GetLocalPhone$MaskPhoneData msg_mask_phone_data = new GetLocalPhone$MaskPhoneData();
    public GetLocalPhone$EncryptPhoneData msg_encrypt_phone_data = new GetLocalPhone$EncryptPhoneData();
    public GetLocalPhone$GuidChangeMibaoData msg_guid_change_mibao_data = new GetLocalPhone$GuidChangeMibaoData();
    public GetLocalPhone$AuthDeviceSucceedData msg_auth_device_succed_data = new GetLocalPhone$AuthDeviceSucceedData();
}
