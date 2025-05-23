package ws3;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bs {
    public static final br a(Object[] objArr) {
        Iterator it = ArrayIteratorKt.iterator(objArr);
        br brVar = new br();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "fileSetId")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                brVar.f446187a = (String) next2;
            } else if (Intrinsics.areEqual(next, "name")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                brVar.f446188b = (String) next3;
            } else if (Intrinsics.areEqual(next, "namePinyin")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
            } else if (Intrinsics.areEqual(next, "totalFileCount")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                brVar.f446189c = vs3.a.b((String) next5);
            } else if (Intrinsics.areEqual(next, "totalFileSize")) {
                Object next6 = it.next();
                Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                brVar.f446190d = vs3.a.b((String) next6);
            } else {
                if (Intrinsics.areEqual(next, QCircleDaTongConstant.ElementParamValue.PERMISSION)) {
                    Object next7 = it.next();
                    Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) next7).intValue();
                    Object[] objArr2 = new Object[intValue];
                    for (int i3 = 0; i3 < intValue; i3++) {
                        objArr2[i3] = it.next();
                    }
                    ee.a(objArr2);
                } else if (Intrinsics.areEqual(next, "shareInfo")) {
                    Object next8 = it.next();
                    Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) next8).intValue();
                    Object[] objArr3 = new Object[intValue2];
                    for (int i16 = 0; i16 < intValue2; i16++) {
                        objArr3[i16] = it.next();
                    }
                    Iterator it5 = ArrayIteratorKt.iterator(objArr3);
                    while (it5.hasNext()) {
                        Object next9 = it5.next();
                        if (Intrinsics.areEqual(next9, "shareLink")) {
                            Object next10 = it5.next();
                            Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.String");
                        } else if (Intrinsics.areEqual(next9, "extractionCode")) {
                            Object next11 = it5.next();
                            Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.String");
                        }
                    }
                } else if (Intrinsics.areEqual(next, "cover")) {
                    Object next12 = it.next();
                    Intrinsics.checkNotNull(next12, "null cannot be cast to non-null type kotlin.Int");
                    int intValue3 = ((Integer) next12).intValue();
                    Object[] objArr4 = new Object[intValue3];
                    for (int i17 = 0; i17 < intValue3; i17++) {
                        objArr4[i17] = it.next();
                    }
                    brVar.f446191e = eh.a(objArr4);
                } else if (Intrinsics.areEqual(next, "uploaders")) {
                    Object next13 = it.next();
                    Intrinsics.checkNotNull(next13, "null cannot be cast to non-null type kotlin.Int");
                    int intValue4 = ((Integer) next13).intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i18 = 0; i18 < intValue4; i18++) {
                        Object next14 = it.next();
                        Intrinsics.checkNotNull(next14, "null cannot be cast to non-null type kotlin.Int");
                        int intValue5 = ((Integer) next14).intValue();
                        Object[] objArr5 = new Object[intValue5];
                        for (int i19 = 0; i19 < intValue5; i19++) {
                            objArr5[i19] = it.next();
                        }
                        arrayList.add(et.a(objArr5));
                    }
                    brVar.f446192f = arrayList;
                } else if (Intrinsics.areEqual(next, "expireLeftTime")) {
                    Object next15 = it.next();
                    Intrinsics.checkNotNull(next15, "null cannot be cast to non-null type kotlin.String");
                    brVar.f446193g = vs3.a.a((String) next15);
                } else if (Intrinsics.areEqual(next, "aiClusteringStatus")) {
                    Object next16 = it.next();
                    Intrinsics.checkNotNull(next16, "null cannot be cast to non-null type kotlin.Int");
                    int intValue6 = ((Integer) next16).intValue();
                    Object[] objArr6 = new Object[intValue6];
                    for (int i26 = 0; i26 < intValue6; i26++) {
                        objArr6[i26] = it.next();
                    }
                    brVar.f446194h = b.a(objArr6);
                } else if (Intrinsics.areEqual(next, WadlProxyConsts.CREATE_TIME)) {
                    Object next17 = it.next();
                    Intrinsics.checkNotNull(next17, "null cannot be cast to non-null type kotlin.String");
                    vs3.a.b((String) next17);
                } else if (Intrinsics.areEqual(next, "expireTime")) {
                    Object next18 = it.next();
                    Intrinsics.checkNotNull(next18, "null cannot be cast to non-null type kotlin.String");
                    brVar.f446195i = vs3.a.b((String) next18);
                } else if (Intrinsics.areEqual(next, "firstLevelItemCount")) {
                    Object next19 = it.next();
                    Intrinsics.checkNotNull(next19, "null cannot be cast to non-null type kotlin.String");
                    brVar.f446196j = vs3.a.a((String) next19);
                } else if (Intrinsics.areEqual(next, "svrLastUpdateTimestamp")) {
                    Object next20 = it.next();
                    Intrinsics.checkNotNull(next20, "null cannot be cast to non-null type kotlin.String");
                    vs3.a.b((String) next20);
                } else if (Intrinsics.areEqual(next, MiniAppGetGameTaskTicketServlet.KEY_TASKID)) {
                    Object next21 = it.next();
                    Intrinsics.checkNotNull(next21, "null cannot be cast to non-null type kotlin.String");
                } else if (Intrinsics.areEqual(next, "uploadInfo")) {
                    Object next22 = it.next();
                    Intrinsics.checkNotNull(next22, "null cannot be cast to non-null type kotlin.Int");
                    int intValue7 = ((Integer) next22).intValue();
                    Object[] objArr7 = new Object[intValue7];
                    for (int i27 = 0; i27 < intValue7; i27++) {
                        objArr7[i27] = it.next();
                    }
                    Iterator it6 = ArrayIteratorKt.iterator(objArr7);
                    er erVar = new er();
                    while (it6.hasNext()) {
                        Object next23 = it6.next();
                        if (Intrinsics.areEqual(next23, "totalUploadedFileSize")) {
                            Object next24 = it6.next();
                            Intrinsics.checkNotNull(next24, "null cannot be cast to non-null type kotlin.String");
                            vs3.a.b((String) next24);
                        } else if (Intrinsics.areEqual(next23, "successCount")) {
                            Object next25 = it6.next();
                            Intrinsics.checkNotNull(next25, "null cannot be cast to non-null type kotlin.String");
                            erVar.f446359a = vs3.a.a((String) next25);
                        } else if (Intrinsics.areEqual(next23, "failedCount")) {
                            Object next26 = it6.next();
                            Intrinsics.checkNotNull(next26, "null cannot be cast to non-null type kotlin.String");
                            erVar.f446360b = vs3.a.a((String) next26);
                        }
                    }
                    brVar.f446197k = erVar;
                } else if (Intrinsics.areEqual(next, "downloadInfo")) {
                    Object next27 = it.next();
                    Intrinsics.checkNotNull(next27, "null cannot be cast to non-null type kotlin.Int");
                    int intValue8 = ((Integer) next27).intValue();
                    Object[] objArr8 = new Object[intValue8];
                    for (int i28 = 0; i28 < intValue8; i28++) {
                        objArr8[i28] = it.next();
                    }
                    Iterator it7 = ArrayIteratorKt.iterator(objArr8);
                    x xVar = new x();
                    while (it7.hasNext()) {
                        Object next28 = it7.next();
                        if (Intrinsics.areEqual(next28, "totalDownloadedFileSize")) {
                            Object next29 = it7.next();
                            Intrinsics.checkNotNull(next29, "null cannot be cast to non-null type kotlin.String");
                            vs3.a.b((String) next29);
                        } else if (Intrinsics.areEqual(next28, "totalFileSize")) {
                            Object next30 = it7.next();
                            Intrinsics.checkNotNull(next30, "null cannot be cast to non-null type kotlin.String");
                            vs3.a.b((String) next30);
                        } else if (Intrinsics.areEqual(next28, "totalDownloadFileCount")) {
                            Object next31 = it7.next();
                            Intrinsics.checkNotNull(next31, "null cannot be cast to non-null type kotlin.String");
                            xVar.f446401a = vs3.a.b((String) next31);
                        } else if (Intrinsics.areEqual(next28, "successCount")) {
                            Object next32 = it7.next();
                            Intrinsics.checkNotNull(next32, "null cannot be cast to non-null type kotlin.String");
                            xVar.f446402b = vs3.a.a((String) next32);
                        } else if (Intrinsics.areEqual(next28, "failedCount")) {
                            Object next33 = it7.next();
                            Intrinsics.checkNotNull(next33, "null cannot be cast to non-null type kotlin.String");
                            xVar.f446403c = vs3.a.a((String) next33);
                        } else if (Intrinsics.areEqual(next28, "pausedCount")) {
                            Object next34 = it7.next();
                            Intrinsics.checkNotNull(next34, "null cannot be cast to non-null type kotlin.String");
                            xVar.f446404d = vs3.a.a((String) next34);
                        } else if (Intrinsics.areEqual(next28, "cancelCount")) {
                            Object next35 = it7.next();
                            Intrinsics.checkNotNull(next35, "null cannot be cast to non-null type kotlin.String");
                            vs3.a.a((String) next35);
                        } else if (Intrinsics.areEqual(next28, "status")) {
                            Object next36 = it7.next();
                            Intrinsics.checkNotNull(next36, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetDownloadTaskStatusKt.FileSetDownloadTaskStatus }");
                            ((Integer) next36).intValue();
                        }
                    }
                    brVar.f446198l = xVar;
                } else if (Intrinsics.areEqual(next, "transferType")) {
                    Object next37 = it.next();
                    Intrinsics.checkNotNull(next37, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetListTypeKt.FileSetListType }");
                    brVar.f446199m = ((Integer) next37).intValue();
                } else if (Intrinsics.areEqual(next, "isLocalCreate")) {
                    Object next38 = it.next();
                    Intrinsics.checkNotNull(next38, "null cannot be cast to non-null type kotlin.Int");
                    brVar.f446200n = ((Integer) next38).intValue() == 1;
                } else if (Intrinsics.areEqual(next, "status")) {
                    Object next39 = it.next();
                    Intrinsics.checkNotNull(next39, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetStatusKt.FileSetStatus }");
                    brVar.f446201o = ((Integer) next39).intValue();
                } else if (Intrinsics.areEqual(next, "uploadStatus")) {
                    Object next40 = it.next();
                    Intrinsics.checkNotNull(next40, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetUploadStatusKt.FileSetUploadStatus }");
                    brVar.f446202p = ((Integer) next40).intValue();
                } else if (Intrinsics.areEqual(next, "uploadPauseReason")) {
                    Object next41 = it.next();
                    Intrinsics.checkNotNull(next41, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FlashTransferPauseReasonKt.FlashTransferPauseReason }");
                    ((Integer) next41).intValue();
                } else if (Intrinsics.areEqual(next, VirtualAppProxy.KEY_DOWNLOAD_STATUS)) {
                    Object next42 = it.next();
                    Intrinsics.checkNotNull(next42, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetDownloadStatusKt.FileSetDownloadStatus }");
                    brVar.f446203q = ((Integer) next42).intValue();
                } else if (Intrinsics.areEqual(next, "downloadPauseReason")) {
                    Object next43 = it.next();
                    Intrinsics.checkNotNull(next43, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FlashTransferPauseReasonKt.FlashTransferPauseReason }");
                    ((Integer) next43).intValue();
                } else if (Intrinsics.areEqual(next, "saveFileSetDir")) {
                    Object next44 = it.next();
                    Intrinsics.checkNotNull(next44, "null cannot be cast to non-null type kotlin.String");
                } else if (Intrinsics.areEqual(next, "localCoverPath")) {
                    Object next45 = it.next();
                    Intrinsics.checkNotNull(next45, "null cannot be cast to non-null type kotlin.String");
                }
            }
        }
        return brVar;
    }
}
