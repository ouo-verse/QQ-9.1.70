package tencent.im.oidb.cmd0x857;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupOpenSysMsg$LightApp extends MessageMicro<GroupOpenSysMsg$LightApp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"app", "view", "desc", "prompt", "ver", PublicAccountMessageUtilImpl.META_NAME, DownloadInfo.spKey_Config, "source"}, new Object[]{"", "", "", "", "", "", "", null}, GroupOpenSysMsg$LightApp.class);
    public final PBStringField app = PBField.initString("");
    public final PBStringField view = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
    public final PBStringField ver = PBField.initString("");
    public final PBStringField meta = PBField.initString("");
    public final PBStringField config = PBField.initString("");
    public GroupOpenSysMsg$Source source = new GroupOpenSysMsg$Source();
}
