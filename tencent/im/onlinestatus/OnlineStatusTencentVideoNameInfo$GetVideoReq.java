package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusTencentVideoNameInfo$GetVideoReq extends MessageMicro<OnlineStatusTencentVideoNameInfo$GetVideoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cid"}, new Object[]{""}, OnlineStatusTencentVideoNameInfo$GetVideoReq.class);
    public final PBStringField cid = PBField.initString("");
}
