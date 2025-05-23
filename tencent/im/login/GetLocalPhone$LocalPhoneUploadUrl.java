package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$LocalPhoneUploadUrl extends MessageMicro<GetLocalPhone$LocalPhoneUploadUrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88}, new String[]{"str_upload_url", "int32_channel_id"}, new Object[]{"", 0}, GetLocalPhone$LocalPhoneUploadUrl.class);
    public final PBStringField str_upload_url = PBField.initString("");
    public final PBInt32Field int32_channel_id = PBField.initInt32(0);
}
