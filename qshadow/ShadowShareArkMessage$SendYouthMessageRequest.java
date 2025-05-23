package qshadow;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowShareArkMessage$SendYouthMessageRequest extends MessageMicro<ShadowShareArkMessage$SendYouthMessageRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "share_receiver_type", "receiveId", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "coverId"}, new Object[]{0, 0, 0L, "", 0}, ShadowShareArkMessage$SendYouthMessageRequest.class);
    public final PBEnumField share_type = PBField.initEnum(0);
    public final PBEnumField share_receiver_type = PBField.initEnum(0);
    public final PBUInt64Field receiveId = PBField.initUInt64(0);
    public final PBStringField materialId = PBField.initString("");
    public final PBEnumField coverId = PBField.initEnum(0);
}
