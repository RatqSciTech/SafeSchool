/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* global getAssetRegistry getFactory emit */

/**
 * Sample transaction processor function.
 * @param {org.example.basic.SampleTransaction} tx The sample transaction instance.
 * @transaction
 */
async function sampleTransaction(tx) {  // eslint-disable-line no-unused-vars

    // Save the old value of the asset.
    //const oldValue = tx.asset.value;
   var d = Date(Date.now());
   
  
    // Update the asset with the new value.
   // tx.asset.value = tx.newValue;
   
    // Get the asset registry for the asset.
    const assetRegistry = await getAssetRegistry('org.example.basic.Issue');
  // Get the Issue asset registry.
  var list = await assetRegistry.getAll();
  const IssueID = "ISS"+parseInt(list.length)+1;

    
    // Create the Issue.
   let Issue = getFactory().newResource('org.example.basic', 'Issue', IssueID);
  
    Issue.details = tx.details;
  Issue.reportedBy = tx.reportedBy;
  Issue.timeStamp = String(d);
   Issue.priority = tx.priority;
  
  
    // Add the Issue to the Issue asset registry.
   await assetRegistry.add(Issue);
 
  
    // Update the asset in the asset registry.
    //await assetRegistry.add(tx.asset);

    // Emit an event for the Created Issue.
    let event = getFactory().newEvent('org.example.basic', 'CreateIssue');
    event.isanonymous  = tx.isanonymous;
  event.issueId = Issue.assetId;
  
  event.totalIssues = parseInt(list.length)+1;
  if (!event.isanonymous) {
  event.reportedBy = tx.reportedBy;
}
  else
  {
    const participantRegistry = await getParticipantRegistry('org.example.basic.SampleParticipant');
    //let participant = getFactory().participantRegistry.get("ANMS")
   event.reportedBy = await participantRegistry.get("ANMS") ;
  }
   event.asset =  Issue; 
    emit(event);
}
