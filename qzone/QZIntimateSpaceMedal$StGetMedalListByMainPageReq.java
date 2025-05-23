package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceMedal$StGetMedalListByMainPageReq extends MessageMicro<QZIntimateSpaceMedal$StGetMedalListByMainPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"space_id"}, new Object[]{""}, QZIntimateSpaceMedal$StGetMedalListByMainPageReq.class);
    public final PBStringField space_id = PBField.initString("");
}
